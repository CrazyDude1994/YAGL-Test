# YAGL-Test

This repository is created as test application.

## Libraries & patterns

### Libraries

RxJava
Dagger2
Github Android SDK (I could map REST request via Retrofit+RxJava, but it's already done in this SDK)
GSON
ActiveAndroid
ButterKnife

### Patterns
UI - MVP
Database & caching - Repository pattern

## Comments

This repository should be perceived just as test application. There is no way to logout from your account. However, I've implemented some network & error checks.
Also you can swipe-2-refresh repository list. Repositories are stored to database once fetched. 

This application first tries to load data from db, also it runs network request for updates, and then shows the results, if it's success.

## TODO

Implement some basic automation tests
