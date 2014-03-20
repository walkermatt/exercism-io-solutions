(ns word-count)

(defn word-count
  [s]
  (frequencies (re-seq #"\w+" (clojure.string/lower-case s))))


