(ns log-levels
  (:require [clojure.string :as str]))

(def levels #{"[ERROR]:" "[WARNING]:" "[INFO]:"})
(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (str/trim (str/join " "
                      (filter (complement levels)
                              (str/split s #" ")))))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (let [level (str/lower-case (first (filter levels (str/split s #" "))))]
    (subs level 1 (- (count level) 2))))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (str (message s) " (" (log-level s) ")"))
