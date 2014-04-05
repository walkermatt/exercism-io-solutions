(ns leap-year)

(defn div?
  [d n]
  (zero? (mod n d)))

(defn leap-year?
  [n]
  (and (div? 4 n) (or (not (div? 100 n)) (div? 400 n))))
