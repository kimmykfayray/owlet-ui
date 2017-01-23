(ns owlet-ui.config)


(def debug?
  ^boolean js/goog.DEBUG)

(when debug?
  (enable-console-print!))


;; TODO:
;; Use a lein env var like the one above
;; to toggle this during development
;; http://localhost:3000
(def server-url
  "https://owlet-api.herokuapp.com")


(defonce project-name "OWLET")


(defonce auth0-local-storage-key "owlet:user-token")

(def auth0-init
  "Credentials for instantiating Auth0 and Auth0Lock objects.
  "
  {:clientID "aCHybcxZ3qE6nWta60psS0An1jHUlgMm"
   :domain   "codefordenver.auth0.com"})


(def auth0-delegation-options
  "The options needed by function Auth0.getDelegationToken. Omit key :id_token,
  since it will be provided by owlet-ui.auth0/on-authenticated. See
  https://auth0.com/docs/libraries/auth0js#delegation-token-request
  "
  {:api      "firebase"
   :scope    "openid profile"
   :target   (:clientID auth0-init)})


(def firebase-app-init
  {:apiKey        "AIzaSyAbs6wXxPGX-8XEWR6nyj7iCETOL6dZjzY"
   :authDomain    "owlet-users.firebaseapp.com"
   :databaseURL   "https://owlet-users.firebaseio.com"
   :storageBucket "owlet-users.appspot.com"})


(def library-space-id "c7i369745nqp")
(def owlet-activities-2-space-id "ir2v150dybog")


(def default-header-bg-image "mg/default_background.png")


(def default-user-db
  "initial user state"
  {:logged-in?                false
   :social-id                 nil
   :content-entries           []
   :background-image          config/default-header-bg-image
   :background-image-entry-id nil})
(def default-db
  "initial app state"
  {:active-view                  nil
   :user                         default-user-db
   :app                          {:loading?     nil
                                  :open-sidebar false
                                  :route-params {}
                                  :title        (str config/project-name " " "^OvO^")}
   :activities                   []
   :activity-branches            nil
   :activities-by-branch-in-view nil
   :activities-by-branch         {}
   :active-branch-activities     nil
   :id                           nil
   :activity-in-view             nil})

