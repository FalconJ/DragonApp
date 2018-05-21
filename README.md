# DragonApp, Manager for your Dungeons & Dragons 5e

In this application you will be able to register and login into our webserver that is hoster in the Google Cloud Platform using an instance of [Nakama](https://github.com/heroiclabs/nakama).

## About
This app was made using [Architecture Components](https://developer.android.com/topic/libraries/architecture/).

## Classes
Below is a description of the different packages and classes in the app code.

### `data` package
Contains all classes related to local and network app data. With some adapters because I didn't notice...

##### `data.network` package
All classes related to fetching data from the network.

* Register and Login in Nakama server.
* Room creation and joining in Nakama server. (WIP)

##### `data.database` package
All classes related to caching the data locally (it's pretty empty right now).
* `CharacterEntry` - A simple Java object representing one character.


### `ui` package
All activities and adapters - anything to do with display.

##### `ui.character` package
* `NewCharacterActivity` - [`Activity`](https://developer.android.com/reference/android/app/Activity.html) to create a new Character

##### `ui.detail` package
* `DetailActivity` - [`Activity`](https://developer.android.com/reference/android/app/Activity.html) for a single character, this combines the usage of Fragments to display the information.

##### `ui.login` package
* `LogInActivity` - [`Activity`](https://developer.android.com/reference/android/app/Activity.html) to enter the application.

##### `ui.room` package
* `RoomActivity` - [`Activity`](https://developer.android.com/reference/android/app/Activity.html) join and create a room.

#### `dndapp` package
* `MainActivty` - [`Activity`](https://developer.android.com/reference/android/app/Activity.html) for a list of `CharacterEntry` objects.

* `LogicCreation` -  Utility methods related to create a new character, as well as, serialize and unserialize CharacterEntry objects (JSON).

#### `data.adapters` package
* `CharacterListAdapter2` - [`RecyclerView.Adapter`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView.Adapter.html) for displaying the list of `CharacterEntry` entries.

### AppExectuors class
This class provides a global executor pool.

