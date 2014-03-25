(ns phone)

(defn digits
  [n]
  (let [digits (re-seq #"\d" n)
        cnt (count digits)]
    (if (= cnt 10)
      digits
      (if (and (= cnt 11) (= (first digits) "1"))
        (drop 1 digits)
        (repeat 10 "0")))))

(defn number
  [n]
  (apply str (digits n)))

(defn area-code
  [n]
  (apply str (take 3 (digits n))))

(defn pretty-print
  [n]
  (let [[_ & parts] (re-find #"(\d{3})(\d{3})(\d{4})" (number n))]
    (apply format "(%s) %s-%s" parts)))
