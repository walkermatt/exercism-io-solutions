(ns dna)

(defn hamming-distance
  [a b]
  (reduce (fn [n i] (if i (inc n) n)) 0 (map not= a b)))
