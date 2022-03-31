(ns test
  (:require [clojure.tools.build.api :as b]))

(defn vwrite
  [{:keys [v]}]
  (b/process
    (b/java-command {:basis (b/create-basis {:project {:deps {'org.clojure/clojure {:mvn/version v}}}})
                     :main 'clojure.main
                     :main-args ["-e" "((requiring-resolve 'obj/write))"]})))

(defn vread
  [{:keys [v]}]
  (b/process
    (b/java-command {:basis (b/create-basis {:project {:deps {'org.clojure/clojure {:mvn/version v}}}})
                     :main 'clojure.main
                     :main-args ["-e" "((requiring-resolve 'obj/read))"]})))

(comment
  (vwrite {:v "1.10.3"})
  (vread {:v "1.10.3"})
  (vread {:v "1.11.0"})
  (vread {:v "1.12.0-master-SNAPSHOT"})

  (require '[clojure.java.io :as io])
  (io/resource "clojure/tools/build/api.clj")
  )