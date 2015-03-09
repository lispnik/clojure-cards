(ns clojure-cards.core
  (:require [clojure.string :refer [join]]))

(defn cards
  ([] (cards (find-ns 'clojure.core)))
  ([ns]
   (let [publics (ns-publics ns)]
     (map (fn [[name symbol]]
            (let [{:keys [doc arglists]} (meta symbol)]
              {:front (str name "\n\n" (join "\n" (map str arglists)))
               :back (if (nil? doc) "(no doc)" doc)}))
          publics))))
