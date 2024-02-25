(defproject site.core "0.1"
  :description "Webpage"
  :url "https://christian.stjernberg.com/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v20.html"}

  :min-lein-version "2.7.1"

  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.11.4"]
                 [cljs-http/cljs-http  "0.1.48"]
                 [cljsjs/react "17.0.2-0"]
                 [cljsjs/react-dom "17.0.2-0"]
                 [reagent "1.1.1"]
                 [lein-tailwind "0.1.2"]]

  :source-paths ["src"]

  :plugins [[lein-tailwind "0.1.2"]]

  :hooks [leiningen.tailwind]

  :tailwind {:tailwind-dir "resources/public/css/tailwind"
             :output-dir   "resources/public/css"
             :tailwind-config  "tailwind.config.js" ;; tailwind.config.js is the default value
             :styles [{:src "main.css"
                       :dst "main.css"}]}

  :aliases {"fig:build" ["trampoline" "run" "-m" "figwheel.main" "-b" "dev" "-r"]
            "fig:min"   ["run" "-m" "figwheel.main" "-O" "advanced" "-bo" "dev"]}

  :profiles {:dev {:dependencies [[com.bhauman/figwheel-main "0.2.17"]
                                  [org.slf4j/slf4j-nop "1.7.30"]
                                  [com.bhauman/rebel-readline-cljs "0.1.4"]]

                   :resource-paths ["target"]
                   ;; need to add the compiled assets to the :clean-targets
                   :clean-targets ^{:protect false} ["target"]}})
