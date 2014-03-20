(ns word-count)

(defn word-count
  [s]
  (frequencies (map clojure.string/lower-case (re-seq #"\w+" s))))


