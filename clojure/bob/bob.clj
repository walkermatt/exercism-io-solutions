(ns bob
  (:require [clojure.string :as string]))

(defn shouting?
  "A string with no lower-case characters and some upper-case characters"
  [msg]
  (and (= msg (string/upper-case msg))
       (not (= msg (string/lower-case msg)))))

(defn question?
  "Question mark at the end of a string"
  [msg]
  (= (last msg) \?))

(defn saying-nothing?
  "Only whitespace"
  [msg]
  (empty? (string/trim msg)))

(def responses
  "List of responses for a give predicate. Each entry is of the form [pred msg]"
  [[shouting? "Woah, chill out!"]
   [question? "Sure."]
   [saying-nothing? "Fine. Be that way!"]
   [identity "Whatever."]])

(defn response-for
  "Bob's response to a given message. Returns the message associated with the
  first predicate to return a truthy value in the responses vector."
  [msg]
  (some #(if ((first %) msg) (last %)) responses))
