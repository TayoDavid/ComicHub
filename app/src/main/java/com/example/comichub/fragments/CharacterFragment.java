package com.example.comichub.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comichub.CharacterDetailActivity;
import com.example.comichub.R;
import com.example.comichub.adapter.CustomGridAdapter;
import com.example.comichub.listener.OnItemClickListener;
import com.example.comichub.model.ApiResponse;
import com.example.comichub.model.characters.Character;
import com.example.comichub.model.utils.Utils;
import com.example.comichub.service.APIClient;
import com.example.comichub.service.HubAPIService;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterFragment extends Fragment implements OnItemClickListener<Character> {

    private final List<Character> characters = null;
    CustomGridAdapter adapter;
    RecyclerView recyclerView;
    ProgressBar progressBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.recycler_view_container, container, false);

        recyclerView = root.findViewById(R.id.recycler_view);
        progressBar = root.findViewById(R.id.progress_bar_indeterminate);
        progressBar.setVisibility(View.VISIBLE);

        adapter = new CustomGridAdapter(characters);
        adapter.attachListener(this);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        HubAPIService apiService = APIClient.getClient().create(HubAPIService.class);
        Map<String, String> apiQueryOptions = Utils.getQueryParam();

        Call<ApiResponse<Character>> userCall = apiService.getCharacters(apiQueryOptions);
        userCall.enqueue(new Callback<ApiResponse<Character>>() {

            @Override
            public void onResponse(@NotNull Call<ApiResponse<Character>> call, @NotNull Response<ApiResponse<Character>> response) {
                if (response.code() == 200) {
                    if (response.body().getData().getResults().size() > 0) {
                        progressBar.setVisibility(View.GONE);
                        adapter.addUpdate(response.body().getData().getResults());
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<ApiResponse<Character>> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });

        return root;
    }

    @Override
    public void onItemClick(Character character) {
        Intent intent = new Intent(getActivity(), CharacterDetailActivity.class);
        intent.putExtra("details", character);
        startActivity(intent);
    }
}
