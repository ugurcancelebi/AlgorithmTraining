package com.example.socialapp.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.socialapp.R;
import com.example.socialapp.constants.Constants;
import com.example.socialapp.model.Article;
import com.example.socialapp.utils.ApplicationUtils;
import com.example.socialapp.utils.DateFormat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Objects;

public class FeedDetailsActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {
    private FrameLayout layoutFeedDate;
    private TextView titleFeedDetailToolbar,subtitleFeedDetailToolbar,dateFeedDetail,timeFeedDetail,titleFeedDetail;
    private String feedURL,feedSource,feedTitle;
    private ImageView imageView;
    private boolean isToolbarHidden;
    private LinearLayout layoutFeedDetail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_details);
        initializeToolbar();
        initializeComponents();
        initializeFeedDetails();
        initializeWebView(feedURL);
    }

    private void initializeComponents() {
        AppBarLayout appBarLayout = findViewById(R.id.application_bar);
        appBarLayout.addOnOffsetChangedListener(this);
        titleFeedDetailToolbar = findViewById(R.id.feed_title_toolbar);
        subtitleFeedDetailToolbar = findViewById(R.id.feed_subtitle_toolbar);
        layoutFeedDetail = findViewById(R.id.toolbar_feed_detail);
        dateFeedDetail = findViewById(R.id.feed_detail_datetime);
        timeFeedDetail = findViewById(R.id.feed_details_timezone);
        titleFeedDetail = findViewById(R.id.feed_detail_title);
        layoutFeedDate = findViewById(R.id.feed_details_date);
        imageView = findViewById(R.id.back_drop_feed_Detail);
    }

    private void initializeFeedDetails(){
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey(Constants.ARTICLE_PARAMS)){
            final Article article = bundle.getParcelable(Constants.ARTICLE_PARAMS);
            if (article != null){
                feedURL = article.getUrl();
                feedTitle = article.getTitle();
                String feedAuthor = article.getAuthor();
                StringBuilder feedInfo = new StringBuilder()
                        .append(" ").append(feedAuthor == null || feedAuthor.isEmpty() ? "Anonymous" : feedAuthor)
                        .append(" ").append(ApplicationUtils.getDate(article.getPublishedAt()));

                titleFeedDetailToolbar.setText(article.getTitle());
                subtitleFeedDetailToolbar.setText(feedURL);
                dateFeedDetail.setText(DateFormat.formatDate(article.getPublishedAt()));
                titleFeedDetail.setText(article.getTitle());
                timeFeedDetail.setText(feedInfo);

                Glide.with(this)
                        .load(article.getUrlToImage())
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(imageView);
            }
        }
    }
    @SuppressLint("SetJavaScriptEnabled")
    private void initializeWebView(String feedURL) {
        WebView webView = findViewById(R.id.feed_detail_web_view);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(feedURL);
    }
    private void initializeToolbar(){
        Toolbar toolbar = findViewById(R.id.feed_detail_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            Objects.requireNonNull(getSupportActionBar()).setTitle("");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_feed_detail);
        collapsingToolbarLayout.setTitle("");
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(verticalOffset)/(float) maxScroll;
        if (percentage == 1f && isToolbarHidden){
            layoutFeedDate.setVisibility(View.GONE);
            layoutFeedDetail.setVisibility(View.VISIBLE);
            isToolbarHidden = !isToolbarHidden;
        }else if(percentage < 1f && !isToolbarHidden){
            layoutFeedDate.setVisibility(View.VISIBLE);
            layoutFeedDetail.setVisibility(View.GONE);
            isToolbarHidden = !isToolbarHidden;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_details,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        switch (id){
            case R.id.view_web:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(feedURL));
                startActivity(intent);
                break;
            case R.id.share:
                try {
                    intent = new Intent(Intent.ACTION_SEND);
                    intent.setType(getString(R.string.textPlan));
                    intent.putExtra(Intent.EXTRA_SUBJECT,feedSource);
                    String body = feedTitle + " " + feedURL;
                    intent.putExtra(Intent.EXTRA_TEXT,body);
                    startActivity(Intent.createChooser(intent,getString(R.string.textShareWith)));
                    break;
                }catch (Exception e){
                    Toast.makeText(this, "Unable to share", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
        }
        return super.onOptionsItemSelected(item);
    }
}
