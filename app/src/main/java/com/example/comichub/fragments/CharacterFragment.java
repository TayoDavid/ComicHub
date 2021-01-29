package com.example.comichub.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comichub.R;
import com.example.comichub.adapter.CustomGridAdapter;
import com.example.comichub.listener.OnItemClickListener;
import com.example.comichub.model.ApiResponse;
import com.example.comichub.model.characters.Character;
import com.example.comichub.model.utils.Utils;
import com.example.comichub.service.APIClient;
import com.example.comichub.service.HubAPIService;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterFragment extends Fragment implements OnItemClickListener<Character> {

    private RecyclerView recyclerView;
    private List<Character> characters = null;
    CustomGridAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = root.findViewById(R.id.recycler_view);

        adapter = new CustomGridAdapter(characters);
        adapter.attachListener(this);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

//        recyclerView.setAdapter(new GridAdapter(new CharacterFragment(), characters));

        HubAPIService apiService = APIClient.getClient().create(HubAPIService.class);
        Map<String, String> apiQueryOptions = Utils.getQueryParam();

        Call<ApiResponse> userCall = apiService.getCharacters(apiQueryOptions);
        userCall.enqueue(new Callback<ApiResponse>() {

            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.code() == 200) {
                    if (response.body().getData().getResults().size() > 0) {
                        Log.e("DDD", "SSSS");
                        adapter.addUpdate(response.body().getData().getResults());
                    }
                } else {
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });


//        Call<ApiResponse<Character>> getCharactersCall = apiService.getCharacters(apiQueryOptions);
//
//        getCharactersCall.enqueue(new Callback<ApiResponse<Character>>() {
//            @Override
//            public void onResponse(@NotNull Call<ApiResponse<Character>> call, @NotNull Response<ApiResponse<Character>> response) {
//                ApiResponse<Character> apiResponse = response.body();
//                ResponseData<Character> data = apiResponse.getData();
//                adapter.addUpdate(data.getResults());
////                characters = data.getResults();
////                recyclerView.setAdapter(new GridAdapter(new CharacterFragment(), characters));
//            }
//
//            @Override
//            public void onFailure(@NotNull Call<ApiResponse<Character>> call, @NotNull Throwable t) {
//                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
//                Log.i("ERROR", t.toString());
//            }
//        });

        return root;
    }

    @Override
    public void onItemClick(Character character) {

    }
}