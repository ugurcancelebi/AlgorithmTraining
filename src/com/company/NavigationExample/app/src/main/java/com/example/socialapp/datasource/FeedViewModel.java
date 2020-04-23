package com.example.socialapp.datasource;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.socialapp.model.Article;
import com.example.socialapp.network.ArticleRepository;
import com.example.socialapp.utils.NetworkState;
import com.example.socialapp.utils.Specification;

import java.util.List;

public class FeedViewModel extends AndroidViewModel {
    private LiveData<NetworkState> networkState;
    private final ArticleRepository articleRepository;

    public FeedViewModel(@NonNull Application application) {
        super(application);
        articleRepository = ArticleRepository.getInstance(application.getApplicationContext());
        initializeViewModel(application);
    }

    private void initializeViewModel(Application application) {
        FeedDataFactory feedDataFactory = new FeedDataFactory(application);
        /*networkState = Transformations.switchMap(feedDataFactory.getMutableLiveData(),
                FeedDataSource::getNetWorkState);*/
    }

    public LiveData<NetworkState> getNetworkState() {
        return networkState;
    }

    public LiveData<List<Article>> getPagedListLiveData(Specification specification) {
        return articleRepository.getArticles(specification);
    }
}
