(ns shadow-cljs-lab.core
  (:require [reagent.core :as reagent :refer [atom]]
            [syn-antd.layout :refer [layout layout-sider layout-header layout-content layout-footer]]
            [syn-antd.menu :refer [menu menu-item menu-sub-menu]]
            [syn-antd.empty]
            [syn-antd.icons.folder-outlined :refer [folder-outlined]]
            [syn-antd.icons.file-word-outlined :refer [file-word-outlined]]
            [syn-antd.icons.file-pdf-outlined :refer [file-pdf-outlined]]))

;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:text "Hello world!"}))


(defn hello-world []
  [layout
   [layout-sider 
    [:div {:class "logo"} "Lab!"]
    [menu {:mode :inline :theme :dark}
     [menu-item {:key 1} "Home"]
     [menu-sub-menu {:key 2 :title (reagent/as-component [:span [folder-outlined] "Documents"])}
      [menu-item {:key 21} [file-word-outlined] "Foo.docx"]
      [menu-item {:key 22} [file-pdf-outlined] "Bar.pdf"]]]]
   [layout
    [layout-header {:style {:background :yellow}}
     "Submarine"]
    [layout-content
     [:div
      [:h1 (:text @app-state)]
      [:h2 "Edit and watch it change!"]
      [syn-antd.empty/empty]
      [:div "Done"]]]
    [layout-footer {:style {:background :white :color :grey}}
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
