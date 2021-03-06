import com.google.appengine.api.datastore.Entity
import com.google.appengine.api.datastore.KeyFactory

Entity userPrefs
if (params.id) {
	userPrefs = datastore.get(KeyFactory.createKey("UserPreferences", params.id?.toLong()))
} else {
	userPrefs = new Entity("UserPreferences")
}

userPrefs << params.subMap(['keywords', 'runInterval', 'alertViaEmail'])

userPrefs.owner = user.nickname
userPrefs.save()

forward '/'