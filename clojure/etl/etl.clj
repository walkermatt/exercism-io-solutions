(ns etl
  (:require [clojure.string :as st]))

(defn transform-entry
  "Transform an entry in the source map so that each value is a key with the
  key as a value:
    [1 [APPLE ARTICHOKE]] => [apple 1 artichoke 1]"
  [[k v]]
  (interleave (map st/lower-case v) (repeat k)))

(defn transform
  "Transform a map of scrabble scores keyed on score to a map keyed on
  lower-case letter or word:
    {1 [APPLE ARTICHOKE] 2 [BOAT] } => {apple 1 artichoke 1 boat 2}"
  [m]
  (apply hash-map (flatten (map transform-entry m))))
