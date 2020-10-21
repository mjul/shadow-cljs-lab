(ns shadow-cljs-lab.ant
  ;; There is also an Ant Design component called empty:
  (:refer-clojure :exclude [empty])
  (:require [reagent.core :as reagent]
            ;; This is how we reference components individually
            ;; to improve "tree shaking":
            ["antd/es/empty" :default ant-empty]
            ["antd/es/icon" :default ant-icon]
            ["antd/es/layout" :default ant-layout]
            ["antd/es/menu" :default ant-menu]))

(def empty (reagent.core/adapt-react-class ant-empty))

(def icon (reagent.core/adapt-react-class ant-icon))

(def layout (reagent.core/adapt-react-class ant-layout))
(def layout-content (reagent.core/adapt-react-class (.-Content ant-layout)))
(def layout-footer (reagent.core/adapt-react-class (.-Footer ant-layout)))
(def layout-header (reagent.core/adapt-react-class (.-Header ant-layout)))
(def layout-sider (reagent.core/adapt-react-class (.-Sider ant-layout)))

(def menu (reagent.core/adapt-react-class ant-menu))
(def menu-divider (reagent.core/adapt-react-class (.-Divider ant-menu)))
(def menu-item (reagent.core/adapt-react-class (.-Item ant-menu)))
(def menu-item-group (reagent.core/adapt-react-class (.-ItemGroup ant-menu)))
(def menu-sub-menu (reagent.core/adapt-react-class (.-SubMenu ant-menu)))

