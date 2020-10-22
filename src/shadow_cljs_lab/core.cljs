(ns shadow-cljs-lab.core
  (:require [reagent.core :as reagent :refer [atom]]
            [syn-antd.layout :refer [layout layout-sider layout-header layout-content layout-footer]]
            [syn-antd.menu :refer [menu menu-item menu-sub-menu]]
            [syn-antd.empty]
            [syn-antd.row :refer [row]]
            [syn-antd.col :refer [col]]
            [syn-antd.icons.folder-outlined :refer [folder-outlined]]
            [syn-antd.icons.file-word-outlined :refer [file-word-outlined]]
            [syn-antd.icons.file-pdf-outlined :refer [file-pdf-outlined]]
            [syn-antd.card :refer [card]]
            ["@ant-design/charts/es/line" :default adch-line]
            ["@ant-design/charts/es/liquid" :default adch-liquid]
            ))

;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:text "Hello world!"}))

(def line (reagent.core/adapt-react-class adch-line))
(def liquid (reagent.core/adapt-react-class adch-liquid))


(defn line-chart-example []
  [card {:title "Amazing line chart" :bordered true}
   [line {:data [{:year 1991 :value 3}
                 {:year 1992 :value 4}
                 {:year 1993 :value 3.5}
                 {:year 1994 :value 5}
                 {:year 1995 :value 4.9}
                 {:year 1996 :value 6}
                 {:year 1997 :value 7}
                 {:year 1998 :value 9}
                 {:year 1999 :value 13}]
          :width 300 :height 300
          :autoFit false
          :x-field :year
          :y-field :value
          :point {:size 5
                  :shape :diamond}
          :label {:style {:fill "#aaa"}}}]
   ])

(defn liquid-chart-example []
  [card {:title "Wonderful liquid chart" :bordered true}
   [liquid {:percent 0.42 :width 300 :height 300}]])


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
      [:h3 "Ant D components with graphics"]
      [syn-antd.empty/empty]
      [:h3  "Ant Charts"]
      [row {:span 24}
       [col {:span 12}
        [line-chart-example]]
       [col {:span 12}
        [liquid-chart-example]]]
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
