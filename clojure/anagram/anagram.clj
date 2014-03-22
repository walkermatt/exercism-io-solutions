(ns anagram)

(defn anagrams-for
  [word candidates]
  (let [word (clojure.string/lower-case word)
        freq (frequencies word)]
    (filter #(let [candidate (clojure.string/lower-case %)]
               (and (not= word candidate) (= freq (frequencies candidate)))) candidates)))

