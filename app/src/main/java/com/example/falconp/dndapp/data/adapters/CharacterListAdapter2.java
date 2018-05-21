package com.example.falconp.dndapp.data.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.falconp.dndapp.R;
import com.example.falconp.dndapp.data.database.CharacterEntry;

import java.util.List;
import java.util.Locale;

/**
 * Expose a list of Characters from a list of {@link CharacterEntry} to a {@link RecyclerView}
 */
public class CharacterListAdapter2 extends RecyclerView.Adapter<CharacterListAdapter2.CharacterViewHolder> {
    private static final int VIEW_TYPE_MAIN = 0;
    private static final int VIEW_TYPE_OTHER = 1;

    // The context we use to utility methods, app resources and layouts inflaters
    private final Context mContext;

    /*
     * Below, we've defined an interface to handle clicks on items within this Adapter. In the
     * constructor of our ForecastAdapter, we receive an instance of a class that has implemented
     * said interface. We store that instance in this variable to call the onItemClick method whenever
     * an item is clicked in the list.
     */
    private final CharacterAdapterOnItemClickHandler mClickHandler;
    private List<CharacterEntry> mCharacters;

    /**
     * Creates a CharacterListAdapter2.
     *
     * @param context      Used to talk to the UI and app resources
     * @param clickHandler The on-click handler for this adapter. This single handler is called
     *                     when an item is clicked.
     */
    public CharacterListAdapter2(@NonNull Context context, CharacterAdapterOnItemClickHandler clickHandler){
        mContext = context;
        mClickHandler = clickHandler;
    }

    /**
     * This gets called when each new ViewHolder is created. This happens when the RecyclerView
     * is laid out. Enough ViewHolders will be created to fill the screen and allow for scrolling.
     *
     * @param viewGroup The ViewGroup that these ViewHolders are contained within.
     * @param viewType  If your RecyclerView has more than one type of item (like ours does) you
     *                  can use this viewType integer to provide a different layout. See
     *                  {@link android.support.v7.widget.RecyclerView.Adapter#getItemViewType(int)}
     *                  for more details.
     * @return A new CharacterAdapterViewHolder that holds the View for each list item
     */

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        int layoutId = getLayoutIdByType(viewType);
        View view = LayoutInflater.from(mContext).inflate(layoutId, viewGroup, false);
        view.setFocusable(true);
        return new CharacterViewHolder(view);
    }

    /**
     * OnBindViewHolder is called by the RecyclerView to display the data at the specified
     * position. In this method, we update the contents of the ViewHolder to display the weather
     * details for this particular position, using the "position" argument that is conveniently
     * passed into us.
     *
     * @param holder The ViewHolder which should be updated to represent the
     *                                  contents of the item at the given position in the data set.
     * @param position                  The position of the item within the adapter's data set.
     */

    @Override
    public void onBindViewHolder(CharacterViewHolder holder, int position) {
        CharacterEntry character = mCharacters.get(position);
        /**
         * Character Icon
         */
        int charImageResourceId = R.drawable.knight;
        holder.iconView.setImageResource(charImageResourceId);

        /**
         * Character Name
         */
        holder.nameView.setText(character.getCharName());

        /**
         * Class
         */
        holder.descriptionView.setText(character.getCharClass());

        /**
         * Level
         */
        holder.charLevelView.setText(String.format(Locale.getDefault(), "%d", character.getLevel()));

        /**
         * Experience
         */
        holder.charExpView.setText(String.format(Locale.getDefault(), "%d", character.getExp()));
    }

    /**
     * This method simply returns the number of items to display. It is used behind the scenes
     * to help layout our Views and for animations.
     *
     * @return The number of items available in our forecast
     */
    @Override
    public int getItemCount() {
        if (null == mCharacters) return 0;
        return mCharacters.size();
    }

    /**
     * Returns the the layout id depending on whether the list item is a normal item or the larger
     * "Main" list item.
     *
     */
    private int getLayoutIdByType(int viewType) {
        switch (viewType) {

            case VIEW_TYPE_MAIN: {
                return R.layout.list_item_character_main;
            }

            case VIEW_TYPE_OTHER: {
                return R.layout.character_list_item;
            }

            default:
                throw new IllegalArgumentException("Invalid view type, value of " + viewType);
        }
    }


    /**
     * Returns an integer code related to the type of View we want the ViewHolder to be at a given
     * position. This method is useful when we want to use different layouts for different items
     * depending on their position. In Sunshine, we take advantage of this method to provide a
     * different layout for the "main" layout. The "main" layout is only shown in portrait mode
     * with the first item in the list.
     *
     * @param position index within our RecyclerView and list
     * @return the view type (today or future day)
     */
    @Override
    public int getItemViewType(int position) {
        return VIEW_TYPE_OTHER;
    }

    /**
     * Swaps the list used by the ForecastAdapter for its weather data. This method is called by
     * {TODO: @link RoomActivity} after a load has finished. When this method is called, we assume we have
     * a new set of data, so we call notifyDataSetChanged to tell the RecyclerView to update.
     *
     * @param newCharacters the new list of forecasts to use as ForecastAdapter's data source
     */
    public void setCharacters(final List<CharacterEntry> newCharacters){
        mCharacters = newCharacters;
        notifyDataSetChanged();
    }

    /**
     * The interface that receives onItemClick messages.
     */
    public interface CharacterAdapterOnItemClickHandler{
        void onItemClick(CharacterEntry charSelected);
    }

    class CharacterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        final ImageView iconView;

        final TextView nameView;
        final TextView descriptionView;
        final TextView charLevelView;
        final TextView charExpView;

        CharacterViewHolder(View view){
            super(view);

            iconView = view.findViewById(R.id.class_icon);
            nameView = view.findViewById(R.id.char_name);
            descriptionView = view.findViewById(R.id.class_desc);
            charLevelView = view.findViewById(R.id.char_level);
            charExpView = view.findViewById(R.id.char_exp);

            view.setOnClickListener(this);
        }

        /**
         * This gets called by the child views during a click. We fetch the charId that has been
         * selected, and then call the onItemClick handler registered with this adapter, passing that
         * id.
         *
         * @param v the View that was clicked
         */
        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            CharacterEntry charSelected = mCharacters.get(adapterPosition);
            mClickHandler.onItemClick(charSelected);
        }
    }

}
