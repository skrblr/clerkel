(in-ns 'clerkel.core)

(defn- choose-ltgt
  [op]
  (case op
    ">=" >=
    "<=" <=
    ">" >
    "<" <))

(defn- myand
  [& args]
  (every? identity args))

(defn- myor
  [& args]
  (some identity args))

(defn- choose-op
  [op]
  (case op
    "and" (fn 
            [& args]
            (every? identity args))
    "or" (fn
            [& args]
            (some identity args))
    "not" not))

(defn rpn
  [& args]
  (let [rearr (concat
                (filter test/function? args)
                (filter #(not (test/function? %)) args))]
    (println rearr " count " (count rearr))
    (if (test/function? (first rearr))
      (apply (first rearr) (rest rearr))
      (identity rearr))))

(defn- select-action
  [& args]
  (println "select action " args " count " (count args))
  (if (= 1 (count args))
    (identity (first args))
    (apply rpn args)))

(def transform-options
  {:integer read-string
   :ltgt choose-ltgt
   :bool choose-op
   :not choose-op
   :oper rpn
   :expr select-action
   :value identity
   :var identity})

