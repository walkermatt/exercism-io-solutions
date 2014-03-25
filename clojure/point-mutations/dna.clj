(ns dna)

(defn hamming-distance
  [a b]
  (reduce #(if %2 (inc %1) %1) 0 (map not= a b)))
