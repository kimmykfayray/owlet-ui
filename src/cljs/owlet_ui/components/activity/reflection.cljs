(ns owlet-ui.components.activity.reflection
  (:require [cljsjs.marked]))

(defn activity-reflection [activity-data]
  (fn []
    (if-let [reflection (get-in @activity-data [:fields :reflectionQuestions])]
      [:div.activity-reflection-wrap.box-shadow
       [:div.list-title
        [:h3 "Challenge"]]
       [:div {"dangerouslySetInnerHTML"
              #js{:__html (js/marked reflection)}}]])))
