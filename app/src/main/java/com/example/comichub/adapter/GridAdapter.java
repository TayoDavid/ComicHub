package com.example.comichub.adapter;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.comichub.MainActivity;
import com.example.comichub.R;
import com.example.comichub.fragments.ResourcePagerFragment;
import com.example.comichub.model.characters.Character;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ResourceViewHolder> {

    /**
     * A listener that is attached to all ViewHolders to handle image loading events and clicks.
     */
    private interface ViewHolderListener {

        void onLoadCompleted(ImageView view, int adapterPosition);

        void onItemClicked(View view, int adapterPosition);
    }

//    private final RequestManager requestManager;
    private final ViewHolderListener viewHolderListener;
    private final List<Character> characters;

    public GridAdapter(Fragment fragment, List<Character> characters) {
        this.viewHolderListener = new ViewHolderListenerImpl(fragment);
        this.characters = characters;
    }

    @NonNull
    @Override
    public ResourceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RequestManager requestManager = Glide.with(parent);
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_view, parent, false);

        return new ResourceViewHolder(view, requestManager, viewHolderListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ResourceViewHolder holder, int position) {
        String characterName = characters.get(position).getName();
        String imageSrc = characters.get(position).getThumbnail().getPath();
        holder.image.setImageURI(Uri.parse(imageSrc));
        holder.resourceName.setText(characterName);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ResourceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, com.example.comichub.adapter.ResourceViewHolder {

        private final ImageView image;
        private final TextView resourceName;
        private final RequestManager requestManager;
        private final ViewHolderListener viewHolderListener;

        public ResourceViewHolder(@NonNull View itemView, RequestManager requestManager,
                                  ViewHolderListener viewHolderListener) {
            super(itemView);
            this.image = itemView.findViewById(R.id.card_image);
            this.resourceName = itemView.findViewById(R.id.item_name);
            this.requestManager = requestManager;
            this.viewHolderListener = viewHolderListener;
            itemView.findViewById(R.id.card_view).setOnClickListener(this);
        }

        void onBind() {
            int adapterPosition = getAdapterPosition();
            setImage(adapterPosition);
            // Set the string value of the image resource as the unique transition name for the view.
//            image.setTransitionName(String.valueOf(IMAGE_DRAWABLES[adapterPosition]));
        }

        void setImage(final int adapterPosition) {
            // Load the image with Glide to prevent OOM error when the image drawables are very large.
//            requestManager
//                    .load(IMAGE_DRAWABLES[adapterPosition])
//                    .listener(new RequestListener<Drawable>() {
//                        @Override
//                        public boolean onLoadFailed(@Nullable GlideException e, Object model,
//                                                    Target<Drawable> target, boolean isFirstResource) {
//                            viewHolderListener.onLoadCompleted(image, adapterPosition);
//                            return false;
//                        }
//
//                        @Override
//                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable>
//                                target, DataSource dataSource, boolean isFirstResource) {
//                            viewHolderListener.onLoadCompleted(image, adapterPosition);
//                            return false;
//                        }
//                    })
//                    .into(image);
        }

        @Override
        public void onClick(View view) {
            // Let the listener start the ImagePagerFragment.
            viewHolderListener.onItemClicked(view, getAdapterPosition());
        }
    }

    private static class ViewHolderListenerImpl implements ViewHolderListener {

        private final Fragment fragment;
        private final AtomicBoolean enterTransitionStarted;

        ViewHolderListenerImpl(Fragment fragment) {
            this.fragment = fragment;
            this.enterTransitionStarted = new AtomicBoolean();
        }

        @Override
        public void onLoadCompleted(ImageView view, int position) {
            // Call startPostponedEnterTransition only when the 'selected' image loading is completed.
            if (MainActivity.currentPosition != position) {
                return;
            }
            if (enterTransitionStarted.getAndSet(true)) {
                return;
            }
            fragment.startPostponedEnterTransition();
        }

        /**
         * Handles a view click by setting the current position to the given {@code position} and
         * starting a {@link } which displays the image at the position.
         *
         * @param view the clicked {@link ImageView} (the shared element view will be re-mapped at the
         * GridFragment's SharedElementCallback)
         * @param position the selected view position
         */
        @Override
        public void onItemClicked(View view, int position) {
            // Update the position.
            MainActivity.currentPosition = position;

            // Exclude the clicked card from the exit transition (e.g. the card will disappear immediately
            // instead of fading out with the rest to prevent an overlapping animation of fade and move).
            ((TransitionSet) fragment.getExitTransition()).excludeTarget(view, true);

            ImageView transitioningView = view.findViewById(R.id.card_image);
            fragment.getParentFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true) // Optimize for shared element transition
                    .addSharedElement(transitioningView, transitioningView.getTransitionName())
                    .replace(R.id.nav_host_fragment, new ResourcePagerFragment(), ResourcePagerFragment.class
                            .getSimpleName())
                    .addToBackStack(null)
                    .commit();
        }
    }
}
