(ns shadow-cljs-lab.core-test
  (:require
   [cljs.test :refer-macros [deftest is testing are run-tests]]))


(deftest foo-test
  (testing "foo"
    (is (= true true))))

