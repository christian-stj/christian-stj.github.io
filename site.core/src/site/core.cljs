(ns ^:figwheel-hooks site.core
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]))

;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:text "Hello world!"}))

(defn get-app-element []
  (gdom/getElement "app"))

; Styles
(def header "text-left text-xl md:text-3xl box-decoration-clone text-black bg-white px-2")
(def header-big "shrink text-left text-2xl md:text-4xl box-decoration-clone text-black bg-white px-2")
(def project "p-6 bg-neutral-900 mt-6 rounded mb-6 shadow-sm shadow-neutral-900")
(def img "my-3 shadow-lg rounded-sm")
(def social "fa hover:scale-125 transition p-4 visited:text-neutral-400")
(def global "font-mono text-sm md:text-base scroll-auto")

; Navbar
(defn navbar []
  [:nav {:class "flex justify-between bg-black text-white block"}
   [:div {:href "" :class "p-3"} "Christian Stjernberg"]
   [:div {:class "hidden sm:flex"} 
    [:a {:href "https://www.instagram.com/christians_fotografi/" :target "_blank" :class ["fa-instagram" social]}]
    [:a {:href "https://github.com/christian-stj/" :target "_blank" :class ["fa-github" social]}]
    [:a {:href "https://www.linkedin.com/in/christian-stj/" :target "_blank" :class ["fa-linkedin" social]}]]])

; Main app
(defn app []
  [:div {:class global}
   ;; Top
   [navbar]
   ;; Body
   [:div {:class "flex flex-row justify-center text-white m-3"}
    ;; Main Content
    [:div {:class "hidden md:flex basis-1/4"}]
    [:div {:class "md:basis-2/4 center max-w-xs md:max-w-none pt-6"}
     [:div {:class "mb-10"}
      [:span {:class header-big} "About me"]
      [:img {:class "float-right w-1/2 md:w-1/3 xl:w-1/4 rounded-full border border-neutral-900 m-5" :src "./img/portrait.jpeg"}]
      [:div {:class "px-2 my-3"}
       [:p  "Hej! I'm a Computer Science student at KTH currently doing my thesis within the field of cybersecurity.
             I'm involved with multiple different non-profit organizations and work part time as an event technician.
             This is where I keep some of my projects, check them out!"]]]

     ;; Projects
     [:span {:class header-big} "My projects"]
     [:div
     ;; This is where projects go
      [:div {:class project}
       [:span {:class header} "/"]
       [:iframe {:class "aspect-square w-full my-3 shadow-lg" :src "https://christian.stjernberg.com" :title "Christian Stjernberg"}]
       [:p "What is this? Pageception? This is my most recent project, I rewrote and updated my old site with clojurescript. 
        I used Reagent and Tailwind for layout and styling and Leiningen and Figwheel as build/dev tools. 
        The site got a complete new style and it is now also easier to expand and add to the site."]]
      [:div {:class project}
       [:span {:class header} "cljs-snake"]
       [:a {:href "http://christian.stjernberg.com/cljs-snake/" :target "_blank"}
        [:img {:class img :src "./img/snake.png"}]] 
       [:p "A simple snake game project I made to test out reagent and web programming with clojurescript."]]
      [:div {:class project}
       [:span {:class header} "Bee Game"]
       [:a {:href "https://github.com/christian-stj/bee-game" :target "_blank"}
        [:img {:class img :src "./img/bee_game_screens.png"}]]
       [:p "This game was made in one evening after a little bee had visited our ice-cream during lunch. 
        The bee had some ice-cream stuck on it and chilled out on my hand for a few minutes while cleaning it out. 
        In the game the bee must escape the falling stracciatella ice-cream for as long as possible. 
        When struck, the bee is covered with ice-cream and the score is shown on top."]]
      [:div {:class project}
       [:span {:class header} "GitViz - a GitHub Visualization tool"]
       [:a {:href "https://github.com/christian-stj/Visualizing-GitHub" :target "_blank"}
        [:img {:class img :src "./img/gitviz1.png" :alt "GitHub Visualization - Small repo"}]]
       [:p "For our bachelor thesis we developed a visualization tool that visualizes some GitHub data and metadata.
        The graph in the middle shows all repo files and directories as nodes with color and size varying depending on the
        distance from the root. The visualization can be dragged and scrolled and the nodes can also be dragged around.
        To the left there are two menus, one where you can go to different commits and see the file tree at that point in time and
        one where you can see different issues."]
       [:a {:href "https://github.com/christian-stj/Visualizing-GitHub" :target "_blank"}
        [:img {:class img :src "./img/gitviz2.png" :alt "GitHub Visualization - BIG repo"}]]
       [:p "On encouragement from our supervisor we added dark mode because these are a must in modern websites.
        As you can see on the image above the tool did not handle huge repositories well."]]
      [:div {:class project}
       [:span {:class header} "Todo List App"]
       [:img {:class img :src "./img/todo-list.png"}]
       [:p "Full-stack project for an internet programming course, developed together with "
        [:a {:class "text-gray-400" :href "https://github.com/mansand1" :target "_blank"} "@mansand1"]
        " The application was developed with Vue front-end using node backend featuring a nice ORM SQLite database.
        Users could log in and their passwords were salted and hashed and stored in the database together
        with their list information. The site also had a self-signed TLS certificate and was hosted on the
        local machine. "]]
      [:div {:class project}
       [:span {:class header} "Tiny Guitar Hero"]
       [:img {:class img :src "./img/guitar-hero-game.jpg"}]
       [:p "For a project in embedded programming, me and "
        [:a {:class "text-gray-400" :href "https://github.com/theoahfeldt" :target "_blank"} "@theoahfeldt"]
        " developed a Guitar Hero replica. The program was developed for a PIC32 microcontroller using an IO shield and some external buttons
        connected to hardware pins on the chip.
        As you can see on the tiny screen in the image above the player is presented with some dots running
        down the screen where the player must
        press the right combination of buttons and the strum button att the right time to score.
        On the screen above, the player seems to have been a bit early in strumming as is displayed on the screen."]
       [:img {:class img :src "./img/guitar.jpg"}]
       [:p "The entire thing was packed in a flaming hot red case and gathered much interest in the project conference where
        students got to try out each other's projects. The tiny screen was placed inside the little rectangular slot at the side
        of the guitar neck and a speaker was connected to it playing som terribly offbeat square waves.
        Of course, no one could beat my high-score in the game."]]
      [:div {:class project}
       [:span {:class header} "Crappy Chess"]
       [:a {:href "https://github.com/christian-stj/crappy-chess" :target "_blank"}
        [:img {:class img :src "./img/chess.png"}]]
       [:p "Our first \"major\" (3 weeks) project in school at the end of first year. A chess game developed with GoLang using game library Ebiten.
        The players took turns to move
        their pieces to any legal square and the game ended with the capture of the opposing king. The rules castling, en passant and
        pawn promotion as well as check and checkmate were not implemented in the game, hence the \"crappyness\"."]]]]

    ;; Sidebar
    [:div {:class "hidden md:flex basis-1/4 self-start justify-center"} 
    ;;  [:div {:class "mt-20 w-24 bg-neutral-900 rounded p-2 space-y-7"}
    ;;   [:div ]
     ]]


   ;; Footer 
   ;[:footer {:class ""}]
   ])


(defn mount [el]
  (rdom/render [app] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

;; conditionally start your application based on the presence of an "app" element
;; this is particularly helpful for testing this ns without launching the app
(mount-app-element)

;; specify reload hook with ^:after-load metadata
(defn ^:after-load on-reload []
  (mount-app-element)
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )
