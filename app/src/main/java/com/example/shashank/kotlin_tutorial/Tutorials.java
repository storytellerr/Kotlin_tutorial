package com.example.shashank.kotlin_tutorial;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Tutorials extends Fragment {



    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private List<Card> CardList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.tutorials_fragment,null);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        CardList = new ArrayList<>();
        adapter = new CardAdapter(getContext(), CardList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(2), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareAlbums();
        return view;

    }

    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.kotlin,
                R.drawable.kotlin,
                R.drawable.kotlin,
                R.drawable.kotlin,
                R.drawable.kotlin,
                R.drawable.kotlin,
                R.drawable.kotlin,
                R.drawable.kotlin,
                R.drawable.kotlin,
                R.drawable.kotlin,
                R.drawable.kotlin};

        Card a = new Card("card 1", 13, covers[0]);
        CardList.add(a);

        a = new Card("card 2", 8, covers[1]);
        CardList.add(a);

        a = new Card("card 3", 11, covers[2]);
        CardList.add(a);

        a = new Card("card 4", 12, covers[3]);
        CardList.add(a);

        a = new Card("card 5", 14, covers[4]);
        CardList.add(a);

        a = new Card("card 6", 1, covers[5]);
        CardList.add(a);

        a = new Card("card 7", 11, covers[6]);
        CardList.add(a);

        a = new Card("card 8", 14, covers[7]);
        CardList.add(a);

        a = new Card("card 9", 11, covers[8]);
        CardList.add(a);

        a = new Card("card 10", 17, covers[9]);
        CardList.add(a);
        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;}

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
