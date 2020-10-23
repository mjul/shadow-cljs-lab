(ns shadow-cljs-lab.core
  (:require [reagent.core :as reagent :refer [atom]]
            [reagent.dom]
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
            ["@ant-design/charts/es/progress" :default adch-progress]
            ))

;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:text "Hello world!"}))

(def line (reagent.core/adapt-react-class adch-line))
(def liquid (reagent.core/adapt-react-class adch-liquid))
(def progress (reagent.core/adapt-react-class adch-progress))

(defn line-chart-example []
  [card {:title "Amazing line chart" :bordered true :type :inner}
   [line {:data [{:year 1991 :value 3}
                 {:year 1992 :value 4}
                 {:year 1993 :value 3.5}
                 {:year 1994 :value 5}
                 {:year 1995 :value 4.9}
                 {:year 1996 :value 6}
                 {:year 1997 :value 7}
                 {:year 1998 :value 9}
                 {:year 1999 :value 13}]
          :width 100 
          :height 100
          :auto-fit true
          :x-field :year
          :y-field :value
          :point {:size 5
                  :shape :diamond}
          :label {:style {:fill "#aaa"}}}]
   ])

(defn liquid-chart-example []
  [card {:title "Wonderful liquid chart" :bordered true :type :inner}
   [liquid {:percent 0.42 :height 100 :width 100 :auto-fit true}]])

(defn progress-chart-example []
  [card {:title "Make progress great again" :bordered true :type :inner}
   [progress {:height 100 :width 100 :auto-fit true :percent 0.7}]]
  )

(defn hello-world []
  [layout
   [layout-sider 
    [:div {:class "logo"} "Lab!"]
    [menu {:mode :inline :theme :dark}
     [menu-item {:key 1} "Home"]
     [menu-sub-menu {:key 2 :title (reagent/as-element [:span [folder-outlined] "Documents"])}
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
      [card
       [row {:span 24 :gutter 16}
        [col {:span 8}
         [line-chart-example]]
        [col {:span 8}
         [liquid-chart-example]]
        [col {:span 8}
         [progress-chart-example]]]]
      [:div "Done"]]]
    [layout-footer {:style {:background :white :color :grey}}
     "This is the footer"]]]
  )

(defn start []
  (reagent.dom/render [hello-world]
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
