(ns ^:figwheel-hooks site.core
  (:require [clojure.string :refer [split]]
            [goog.dom :as gdom]
            [reagent.core :as reagent :refer [atom]]
            [reagent.dom :as rdom]))

(defn get-app-element []
  (gdom/getElement "app"))

(def styles
  {:header "text-left text-xl md:text-3xl box-decoration-clone text-[#ffaa00] px-2 mt-10"
   :header-big "shrink text-left text-2xl md:text-4xl text-[#ffaa00] px-2 mb-4 mt-14"
   :project "p-6 border-4 border-amber-100 transition mt-6 rounded mb-6 shadow-sm shadow-neutral-900"
   :nav-button "hover:bg-lime-800 flex text-amber-100 p-3 text-center"
   :img "my-3 shadow-lg rounded-sm place-content-center"
   :photo "my-4 mb-8 shadow-lg rounded-sm w-11/12 border-8 border-amber-100"
   :social "fa hover:scale-125 transition p-4"
   :global "font-roboto text-sm md:text-base scroll-auto bg-lime-800 text-amber-100"
   :audio-text "text-amber-100 mb-1 text-xs md:text-sm"
   :tag "text-center text-xl md:text-3xl mb-4 mt-12"})

(defn navbar []
  [:nav {:class "flex justify-between bg-lime-900 text-amber-100 block fixed top-0 left-0 right-0"}
   [:div {:href "" :class "flex"}
    [:a {:href "#top" :class (styles :nav-button)} "Christian Stjernberg"]
    [:a {:href "#projects" :class (styles :nav-button)} "Projects"]
    [:a {:href "#photography" :class (styles :nav-button)} "Photography"]]
   [:div {:class "hidden sm:flex"}
    [:a {:href "https://www.instagram.com/christians_fotografi/" :target "_blank" :class ["fa-instagram" (styles :social)]}]
    [:a {:href "https://github.com/christian-stj/" :target "_blank" :class ["fa-github" (styles :social)]}]
    [:a {:href "https://www.linkedin.com/in/christian-stj/" :target "_blank" :class ["fa-linkedin" (styles :social)]}]]])

(defn tagline []
  [:div {:class (styles :tag)}
   [:em "People, software, music"]])

(defn intro []
  [:div {:class "mb-10"}
   [:h1 {:class (styles :header-big)} "About me"]
   [:img {:class "float-right transition duration-700 w-1/2 md:w-1/3 xl:w-1/4 rounded-full border-4 border-amber-100 m-4" :src "./img/portrait-christian.jpg"}]
   [:div {:class "px-2 my-3"}
    [:p "Hello! 👋" [:br]
     "Welcome to my personal page. I'm Christian, a software developer with a passion for leadership, team dynamics, and culture. When I'm not coding, you'll find me exploring music, photography, and technology. I'm also deeply involved in various non-profit organizations, primarily focusing on youth development. This site showcases some of my technical projects and photography. Feel free to explore and enjoy!"]]])

(def instagram-img-sources (split "./instagram/399885630_377510514700373_8403928561865487818_n.webp ./instagram/173022412_268339418272047_1093431580254147613_n.jpg ./instagram/173080697_506111990420742_6259152929652378186_n.jpg ./instagram/174867484_122504219821507_3048476703950039340_n.jpg ./instagram/175348710_228415745737349_5537444018371090008_n.jpg ./instagram/176209918_184619130158038_786649798004349307_n.jpg ./instagram/177039207_968001270683151_6447398338399227417_n.jpg ./instagram/235767804_151515103791234_1673290746420710077_n.jpg ./instagram/236903349_870350607199238_8841531014078710008_n.jpg ./instagram/242765492_391114712691098_2640414364288285619_n.jpg ./instagram/271834001_461171578952340_1762667053030519977_n.webp ./instagram/312096996_424836823160563_6160720423345877099_n.webp ./instagram/332354676_1042493510044804_8887406124638804060_n.webp ./instagram/357550178_807940630717679_7539186842275922397_n.jpg" " "))

(defn photography []
  [:div {:id "photography"}
   [:h2 {:class (styles :header-big)} "Photography"]
   [:ul (map (fn [src] [:li {:class "flex justify-center"} [:img {:class (styles :photo) :src src}]]) instagram-img-sources)]])

(defn projects []
  [:div {:id "projects"}
   [:h2 {:class (styles :header-big)} "My projects"]
   [:div
    [:div {:class (styles :project)}
     [:span {:class (styles :header)} "/"]
     [:iframe {:class "aspect-square w-full my-3 shadow-lg" :src "https://christian.stjernberg.com" :title "Christian Stjernberg"}]
     [:p "This project is a complete overhaul of my old site using ClojureScript. Leveraging Reagent and Tailwind for layout and styling, and tools like Leiningen and Figwheel for development, I gave the site a fresh new look. It's now more flexible and easier to expand."]]
    [:div {:class (styles :project)}
     [:span {:class (styles :header)} "Alert sound"]
     [:div {:class "my-3 space-y-3"}
      [:div
       [:p {:class (styles :audio-text)} "\"Slideoff\""]
       [:audio {:controls "true"}
        [:source {:src "./audio/CS_sound1_slideoff.mp3"}]]]
      [:div
       [:p {:class (styles :audio-text)} "\"Slideoff\" - in context"]
       [:audio {:controls "true"}
        [:source {:src "./audio/CS_sound1_with_background.mp3"}]]]
      [:div
       [:p {:class (styles :audio-text)} "\"Fifth\""]
       [:audio {:controls "true"}
        [:source {:src "./audio/CS_sound2_fifth.mp3"}]]]
      [:div
       [:p {:class (styles :audio-text)} "\"Fifth\" - in context"]
       [:audio {:controls "true"}
        [:source {:src "./audio/CS_sound2_with_background.mp3"}]]]]
     [:p "In a musical communication course, I designed an alert sound for a retail store. The challenge was to create a sound that blends seamlessly with the background music yet remains noticeable to staff. This alert could be used, for instance, when someone reaches for valuable items. I crafted the sounds by recording my guitar and applying audio effects to ensure they fit perfectly."]]
    [:div {:class (styles :project)}
     [:span {:class (styles :header)} "cljs-snake"]
     [:a {:href "http://christian.stjernberg.com/cljs-snake/" :target "_blank"}
      [:img {:class (styles :img) :src "./img/snake.png"}]]
     [:p "This is a straightforward snake game I developed to experiment with Reagent and ClojureScript for web programming. The snake is controlled with arrow keys, and the grid wraps around the edges for continuous play."]]
    [:div {:class (styles :project)}
     [:span {:class (styles :header)} "Bee Game"]
     [:a {:href "https://github.com/christian-stj/bee-game" :target "_blank"}
      [:img {:class (styles :img) :src "./img/bee_game_screens.png"}]]
     [:p "Inspired by a bee that visited our ice-cream during lunch, I created this game in one evening. The objective is to help the bee dodge falling stracciatella ice-cream. If hit, the bee gets covered in ice-cream, and the final score is displayed. I developed this game using Python and the Pygame library, and I also designed the artwork."]]
    [:div {:class (styles :project)}
     [:span {:class (styles :header)} "GitViz - a GitHub Visualization tool"]
     [:a {:href "https://github.com/christian-stj/Visualizing-GitHub" :target "_blank"}
      [:img {:class (styles :img) :src "./img/gitviz1.png" :alt "GitHub Visualization - Small repo"}]]
     [:p "For my bachelor thesis, my partner and I developed GitViz, a tool to visualize GitHub data. The central graph displays repo files and directories as nodes, with colors and sizes indicating their distance from the root. The visualization is interactive, allowing for dragging and scrolling. There are two menus on the left: one for navigating commits and viewing the file tree at different points in time, and another for viewing issues. We also added a dark mode, a modern necessity. While the tool works well for smaller repositories, it struggles with larger ones."]
     [:a {:href "https://github.com/christian-stj/Visualizing-GitHub" :target "_blank"}
      [:img {:class (styles :img) :src "./img/gitviz2.png" :alt "GitHub Visualization - BIG repo"}]]]
    [:div {:class (styles :project)}
     [:span {:class (styles :header)} "Todo List App"]
     [:img {:class (styles :img) :src "./img/todo-list.png"}]
     [:p "This full-stack project was developed for a web programming course in collaboration with " [:a {:href "https://github.com/mansand1" :target "_blank"} "@mansand1"] ". We used Vue for the front-end and Node.js for the back-end, with an ORM SQLite database. Users can log in, with their passwords securely salted, hashed, and stored. The site also featured a self-signed TLS certificate and was hosted locally."]] [:div {:class (styles :project)}
     [:span {:class (styles :header)} "Tiny Guitar Hero"]
     [:img {:class (styles :img) :src "./img/guitar-hero-game.jpg"}]
     [:p "For an embedded programming project, " [:a {:href "https://github.com/theoahfeldt" :target "_blank"} "@theoahfeldt"] " and I created a Guitar Hero replica. We developed the program for a PIC32 microcontroller using an IO shield and external buttons connected to the chip's hardware pins. Players must press the correct button combinations and strum at the right time as dots scroll down the tiny screen. The entire setup was housed in a striking red case and attracted a lot of attention at our project conference. The screen was embedded in the guitar neck, and a speaker played some wonderfully off-beat square waves. Naturally, no one could beat my high score."]]
    [:div {:class (styles :project)}
     [:span {:class (styles :header)} "Crappy Chess"]
     [:a {:href "https://github.com/christian-stj/crappy-chess" :target "_blank"}
      [:img {:class (styles :img) :src "./img/chess.png"}]]
     [:p "For our first \"major\" (3 weeks) project in school at the end of first year (back in 2018). A chess game developed with GoLang using game library Ebiten. The players took turns to move their pieces to any legal square and the game ended with the capture of the opposing king. The rules castling, en passant and pawn promotion as well as check and checkmate were not implemented in the game, hence the \"crappyness\"."]]]])

(defn footer []
  [:footer {:class "w-full text-xl block text-center"}
   [:p {:class "bg-lime-900 box-decoration-clone tracking-wide p-4"} "© Christian Stjernberg - 2024"]])

(defn app []
  [:div {:class (styles :global)}
   [navbar]
   [:div {:class "flex flex-row justify-center m-3"}
    [:div {:class "md:basis-2/4 center max-w-xs md:max-w-none pt-6"}
     [tagline]
     [intro]
     [projects]
     [photography]]]
   [footer]])

(defn mount [el]
  (rdom/render [app] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

(defn ^:after-load on-reload []
  (mount-app-element))

(mount-app-element)
