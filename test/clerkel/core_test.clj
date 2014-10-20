(ns clerkel.core-test
  (:require [clojure.test :refer :all]
            [clerkel.core :refer :all]))

(deftest greater-than
  (testing "greater than operator"
    (is 
    	(= [:query true] 
    		 (zerkse "x > 1" {"x" 4})))
    (is
    	(= [:query false] 
    		 (zerkse "x > 1" {"x" 1})))))

(deftest greater-than-equal
  (testing "greater than equal operator"
    (is 
    	(= [:query true] 
    		 (zerkse "x >= 2" {"x" 4})))
    (is
    	(= [:query true] 
    		 (zerkse "x >= 2" {"x" 2})))
    (is
    	(= [:query false] 
    		 (zerkse "x >= 2" {"x" 1})))))

(deftest less-than
  (testing "less than operator"
    (is 
    	(= [:query true] 
    		 (zerkse "x < 4" {"x" 1})))
    (is
    	(= [:query false] 
    		 (zerkse "x < 1" {"x" 1})))))

(deftest less-than-equal
  (testing "less than equal operator"
    (is 
    	(= [:query true] 
    		 (zerkse "x <= 4" {"x" 1})))
    (is
    	(= [:query true] 
    		 (zerkse "x <= 2" {"x" 2})))
    (is
    	(= [:query false] 
    		 (zerkse "x <= 2" {"x" 4})))))

