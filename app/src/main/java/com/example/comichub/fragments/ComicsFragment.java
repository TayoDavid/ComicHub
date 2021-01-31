package com.example.comichub.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comichub.CharacterDetailActivity;
import com.example.comichub.ComicDetailActivity;
import com.example.comichub.R;
import com.example.comichub.adapter.ComicsAdapter;
import com.example.comichub.listener.OnItemClickListener;
import com.example.comichub.model.ApiResponse;
import com.example.comichub.model.comics.Comic;
import com.example.comichub.model.utils.Utils;
import com.example.comichub.service.APIClient;
import com.example.comichub.service.HubAPIService;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComicsFragment extends Fragment implements OnItemClickListener<Comic> {

    private final List<Comic> comics = null;
    private ComicsAdapter adapter;
    private ProgressBar progressBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.recycler_view_container, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        progressBar = root.findViewById(R.id.progress_bar_indeterminate);
        progressBar.setVisibility(View.VISIBLE);

        adapter = new ComicsAdapter(comics);
        adapter.attachListener(this);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        HubAPIService apiService = APIClient.getClient().create(HubAPIService.class);
        Map<String, String> apiQueryOptions = Utils.getQueryParam();

        retrofit2.Call<ApiResponse<Comic>> comicsCall = apiService.getComics(apiQueryOptions);
        comicsCall.enqueue(new Callback<ApiResponse<Comic>>() {

            @Override
            public void onResponse(@NotNull retrofit2.Call<ApiResponse<Comic>> call, @NotNull Response<ApiResponse<Comic>> response) {
                if (response.code() == 200) {
                    if (response.body().getData().getResults().size() > 0) {
                        progressBar.setVisibility(View.GONE);
                        adapter.updateComics(response.body().getData().getResults());
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<ApiResponse<Comic>> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });

        return root;
    }

    @Override
    public void onItemClick(Comic comic) {
        Intent intent = new Intent(getActivity(), ComicDetailActivity.class);
        intent.putExtra("comicDetail", comic);
        startActivity(intent);
    }
}
