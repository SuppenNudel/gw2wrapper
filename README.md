# Guild Wars 2 API Wrapper For Android

This is a working-in-progress library for accessing the [Guild Wars 2 API](https://wiki.guildwars2.com/wiki/API:2).

<sub>*PS: This library should also works for Java projects, since I didn't use any android specific library.*</sub>

## How To Use

*Note: when using this library in Android application make sure to require internet permission* 

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

First of all, you need to get GuildWars2 object by calling:

```java
GuildWars2.getInstance();
```

#### API Wrapper Methods

Use methods in ```SynchronousRequest``` class to get the content synchronously, which can be accessed by calling ```getSynchronous()``` function in ```GuildWars2``` class.

For instance, to get content of item [12452 and 28445](https://api.guildwars2.com/v2/items?ids=12452,28445) synchronously:

```java
GuildWars2 api = GuildWars2.getInstance();
int[] ids = new int[]{12452, 28445};
List<Item> result = api.getSynchronous().getItemInfo(ids);
//more amazing codes
```

Use methods in ```AsynchronousRequest``` class to process you the content asynchronously, which can be accessed by calling ```getAsynchronous()``` function in ```GuildWars2``` class.

For instance, to process content of item [12452 and 28445](https://api.guildwars2.com/v2/items?ids=12452,28445) asynchronously:

```java
GuildWars2 api = GuildWars2.getInstance();
int[] ids = new int[]{12452, 28445};
api.getAsynchronous().getItemInfo(ids, new Callback<List<Item>>() {
  @Override
  public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
    //more amazing codes
  }
	
  @Override
  public void onFailure(Call<List<Item>> call, Throwable t) {
    //handle failure
  }
});
```

#### Content Model Classes

Each content model class follows the exact same format presented by [official wiki](https://wiki.guildwars2.com/wiki/API:2). Thus a good way to know what to expect from a model class is to go to the API wiki page and see what is in the 
response for that endpoint.

For example, the response for [/v2/tokeninfo](https://wiki.guildwars2.com/wiki/API:2/tokeninfo):

> id (string) - The API key that was requested.
> name (string) - The name given to the API key by the account owner. <strong>Warning</strong>: The value of this field is not escaped and may contain valid HTML, JavaScript, other code. Handle with care.
> permissions (array) - Array of strings describing which permissions the API key has. The array can contain any of:
> + account - Grants access to the /v2/account endpoint (This permission is required for all API keys).
> + builds - Grants access to view each character's equipped specializations and gear.
> + characters - Grants access to the /v2/characters endpoint.
> + guilds - Grants access to guild info under the /v2/guild/:id/ sub-endpoints.
> + inventories - Grants access to inventories in the /v2/characters, /v2/account/bank, and /v2/account/materials endpoints.
> + progression - Grants access to achievements, dungeon unlock status, mastery point assignments, and general PvE progress.
> + pvp - Grants access to the /v2/pvp sub-endpoints. (i.e. /v2/pvp/games, /v2/pvp/stats)
> + tradingpost - Grants access to the /v2/commerce/transactions endpoint.
> + unlocks - Grants access to the /v2/account/skins and /v2/account/dyes endpoints.
> + wallet - Grants access to the /v2/account/wallet endpoint.


The format for TokenInfo class is:

```java
public class TokenInfo {
  private String id;
  private String name;
  private String[] permissions;
  //getters
}
```

<sub>*Note: If parts of response of an endpoint is not documented on the wiki, I probably will missed it in my model class. 
So if you see anything I missed, please don't hesitate to create an issue to let me know.*</sub>

## Completed Endpoints

*List of Endpoints that is available in this library*

+ /v2/account

+ /v2/account/bank

+ /v2/account/inventory

+ /v2/account/materials

+ /v2/account/wallet

+ /v2/characters/&#60;name&#62;/core

+ /v2/characters/&#60;name&#62;/inventory

+ /v2/colors

+ /v2/commerce/prices

+ /v2/commerce/transactions

+ /v2/currencies

+ /v2/items

+ /v2/itemstats

+ /v2/materials

+ /v2/minis

+ /v2/recipes

+ /v2/recipes/search

+ /v2/skins

+ /v2/tokeninfo

+ /v2/worlds


## Download

Go to [releases](https://github.com/xhsun/gw2wrapper/releases) and find the latest version of this library. 

Or you can clone the repository and compile your own jar file.

#### Location For Android project

After downloaded the jar file, make sure you save it in app/libs folder and while you are at it add `compile files('libs/GuildWars2.jar')` to your build.gradle

## Contributing

#### Issues

If you find anything that is not working as it should be, please don't hesitate to open an issue in the issue tracker.

When reporting an issue, it will help me a lot if you include what you've done that lead to the issue.

#### Credit
 
 + [Retrofit](https://github.com/square/retrofit) for HTTP client

