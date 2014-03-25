(ns dna)

(defn hamming-distance
  [a b]
  (reduce + (map #(if (= %1 %2) 0 1) a b)))
