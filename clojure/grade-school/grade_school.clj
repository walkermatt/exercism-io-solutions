(ns grade_school)

(defn grade
  [db grade]
  (db grade []))

(defn add
  [db pupil grade]
  (update-in db [grade] (comp vec conj) pupil))

(defn sorted
  [db]
  (into (sorted-map) (map #(update-in % [1] sort) db)))
