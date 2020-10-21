(ns shadow-cljs-lab.core
  (:require [reagent.core :as reagent :refer [atom]]
            [shadow-cljs-lab.ant :as ant]))

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))


(defn hello-world []
  [ant/layout
   [ant/layout-sider 
    [:div {:class "logo"} "Lab!"]
    [ant/menu {:mode :inline :theme :dark}
     [ant/menu-item {:key 1} "Home"]
     [ant/menu-sub-menu {:key 2 :title "Documents"}
      [ant/menu-item {:key 21} "Foo.docx"]
      [ant/menu-item {:key 22} "Bar.docx"]]]]
   [ant/layout
    [ant/layout-header {:style {:background :yellow}}
     "Submarine"]
    [ant/layout-content
     [:div
      [:h1 (:text @app-state)]
      [:h2 "Edit and watch it change!"]
      [ant/empty]
      [:div "Done"]]]
    [ant/layout-footer {:style {:background :white :color :grey}}
     "This is the footer"]
    ]]
  )

(defn start []
  (reagent/render-component [hello-world]
                            (. js/document (getElementById "app"))))

(defn ^:export init []
  ;; init is called ONCE when the page loads
  ;; this is called in the index.html and must be exported
  ;; so it is available even in :advanced release builds
  (start))

(defn stop []
  ;; stop is called before any code is reloaded
  ;; this is controlled by :before-load in the config
  (js/console.log "stop"))
