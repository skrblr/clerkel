(in-ns 'clerkel.core)

(defn- choose-operator
  [op]
  (case op
    ">=" >=
    "<=" <=
    ">" >
    "<" <
    "and" #(every? identity %)
    "or" #(some identity %)
    "not" not
    ))

(defn rpn
  [& args]
  (let [rearr (concat
                (filter test/function? args)
                (filter #(not (test/function? %)) args))]
    (apply (first rearr) (rest rearr))))

(def transform-options
  {:integer read-string
   :operator choose-operator
   :operation rpn
   :value identity
   :ltgt identity
   :sexp identity
   :var identity})

