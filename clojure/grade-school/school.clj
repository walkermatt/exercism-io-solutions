(ns school)

(defn grade
  [db grade]
  (get db grade []))

(defn add
  [db pupil grade]
  (assoc db grade (conj (school/grade db grade) pupil)))

(defn sorted
  [db]
  (into {} (map #(update-in % [1] sort) db)))
