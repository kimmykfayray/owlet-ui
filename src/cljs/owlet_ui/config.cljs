(ns owlet-ui.config)


(def debug?
  ^boolean js/goog.DEBUG)

(when debug?
  (enable-console-print!))


(def project-name "OWLET")


;; TODO:
;; Use a lein env var like the one above
;; to toggle this during development
;; http://localhost:3000
(def server-url
  "https://owlet-api.herokuapp.com")


(defonce auth0-local-storage-key "owlet:user-token")


(def auth0-init
  "Credentials for instantiating Auth0 and Auth0Lock objects.
  "
  ;{:clientID aCHybcxZ3qE6nWta60psS0An1jHUlgMm
  ; :domain   "codefordenver.auth0.com"}
  {:clientID "W1JzCkUXk2F2cey55eziGm3k99232tmU"
   :domain   "codefordenver.auth0.com"})


(def auth0-del-opts-for-firebase
  "The options needed by function Auth0.getDelegationToken. Omit key :id_token,
  since it will be provided by owlet-ui.auth0/on-authenticated. See
  https://auth0.com/docs/libraries/auth0js#delegation-token-request
  "
  {:api      "firebase"
   :scope    "openid profile"
   :target   (:clientID auth0-init)})


(defonce firebase-app-init
  ; Used only by owlet-ui.firebase/firebase-app, which may not be redefined
  ; while the app is running. So for clarity, we make this var defonce as well.
  ;
  ;{:apiKey        "AIzaSyAbs6wXxPGX-8XEWR6nyj7iCETOL6dZjzY"
  ; :authDomain    "owlet-users.firebaseapp.com"
  ; :databaseURL   "https://owlet-users.firebaseio.com"
  ; :storageBucket "owlet-users.appspot.com"}
  {:apiKey        "AIzaSyCsyfVjnbyiizTgVNyoKW1LuwULj252W0o"
   :authDomain    "owlet-ui-dev.firebaseapp.com"
   :databaseURL   "https://owlet-ui-dev.firebaseio.com"
   :storageBucket "owlet-ui-dev.appspot.com"})


(def library-space-id "c7i369745nqp")
(def owlet-activities-2-space-id "ir2v150dybog")


(def default-header-bg-image "img/default_background.png")


(def default-user-db
  "initial user state"
  {:logged-in?                false
   :social-id                 nil
   :content-entries           []
   :background-image          default-header-bg-image
   :background-image-entry-id nil})
(def default-db
  "initial app state"
  {:active-view                  nil
   :user                         default-user-db
   :app                          {:loading?     nil
                                  :open-sidebar false
                                  :route-params {}
                                  :title        (str project-name " ^OvO^")}
   :activities                   []
   :activity-branches            nil
   :activities-by-branch-in-view nil
   :activities-by-branch         {}
   :active-branch-activities     nil
   :id                           nil
   :activity-in-view             nil})

