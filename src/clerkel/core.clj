(ns clerkel.core
  (:require [instaparse.core :as insta]
            [clojure.string :as str]
            [clojure.test :as test])
  (:gen-class :main true))

(load "operators")

(def parser 
  (insta/parser (clojure.java.io/resource "zerkel.bnf")))

(defn- replace-vars
  [input vars]
  (let [input (str/lower-case input)]
    (reduce 
      #(str/replace %1 (key %2) (str (val %2)))
      input
      vars)))

(defn zerkse
  [input vars]
  (let [opts transform-options
        input (replace-vars input vars)]
    (->> (parser input) (insta/transform opts))))

(defn parseit
  [input] 
  (parser input))
