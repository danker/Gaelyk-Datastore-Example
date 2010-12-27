import com.breomedia.UserPreferences

import com.google.appengine.api.datastore.*
import static com.google.appengine.api.datastore.FetchOptions.Builder.*

def query = new Query("UserPreferences")
query.addFilter("owner", Query.FilterOperator.EQUAL, user.nickname)
PreparedQuery preparedQuery = DatastoreServiceFactory.datastoreService.prepare(query)

def upEntity = preparedQuery?.asSingleEntity()

UserPreferences up = upEntity as UserPreferences

request.currentUser = user
request.upKey = upEntity?.key
request.userPrefs = up

forward 'edituserprefs.gtpl'