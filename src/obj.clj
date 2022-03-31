(ns obj
  (:refer-clojure :exclude [read])
  (:import
    [java.io ObjectInputStream ObjectOutputStream FileOutputStream FileInputStream]))

(defn write-obj
  [o ^String f]
  (with-open [oos (ObjectOutputStream. (FileOutputStream. f))]
    (.writeObject oos o)))

(defn write
  []
  (write-obj :abc "keyword.ser")
  (write-obj (seq (into-array [1 2 3])) "arrayseq.ser"))

(defn read-obj
  [^String f]
  (with-open [ois (ObjectInputStream. (FileInputStream. f))]
    (.readObject ois)))

(defn read
  []
  (println (= :abc (read-obj "keyword.ser")))
  (println (= [1 2 3] (read-obj "arrayseq.ser"))))