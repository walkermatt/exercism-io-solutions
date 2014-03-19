(ns bob)

(defn some-chars
  "Returns the first char within the given range found in coll"
  [first-char last-char coll]
  (some (set (map char (range (int first-char) (inc (int last-char))))) coll))

(def some-upper (partial some-chars \A \Z))
(def some-lower (partial some-chars \a \z))

(defn shouting?
  "A string with no lower-case characters and some upper-case characters"
  [msg]
  (and (some-upper msg) (not (some-lower msg))))

(defn question?
  "Question mark at the end of a string"
  [msg]
  (re-find #"\?$" msg))

(defn saying-nothing?
  "Only whitespace"
  [msg]
  (empty? (clojure.string/trim msg)))

(defn response-for
  "Bob's response to a given message"
  [msg]
  (if (shouting? msg)
    "Woah, chill out!"
    (if (question? msg)
      "Sure."
      (if (saying-nothing? msg)
        "Fine. Be that way!"
        "Whatever."))))
