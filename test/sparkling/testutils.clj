(ns sparkling.testutils
  (:import [scala Tuple2 Some]))

(defn equals-ignore-order? [c1 c2]
  (= (frequencies c1) (frequencies c2)))


(defn untuple [^Tuple2 t]
  (let [v (transient [])]
    (conj! v (._1 t))
    (conj! v (._2 t))
    (persistent! v)))

(defn untuple-all [coll]
  (map untuple coll))



(defn seq-values [coll]
  (map (fn [[k v]]
         [k (seq v)])
       coll))

(defn some-instance? [cls option]
  (and (instance? Some option) (instance? cls (.get option))))


(defn identity-vec [& args]
  (vec args))

(defn vec$ [x]
  (when x (vec x)))