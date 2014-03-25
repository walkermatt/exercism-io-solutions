(ns dna)

(defn hamming-distance
  [a b]
  (reduce + (map #(if (not= %1 %2) 1 0) a b)))
