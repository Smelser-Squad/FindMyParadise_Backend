<template>
  <div>
    <h2>Things To Do!</h2>

    <horizontal-list :items="items" :options="options">
      <template v-slot:default="{ item }">
        <div>
          <a target="_blank" href="">
            <div class="image-container">
              <img :src="item.imageSrc" />
              <div class="image-overlay">
                <div class="button-container" v-on:click.stop="saved(item.id)">
                  <button>
                    <svg
                      viewBox="0 0 32 32"
                      xmlns="http://www.w3.org/2000/svg"
                      aria-hidden="true"
                      role="presentation"
                      focusable="false"
                      style="
                        display: block;
                        fill: rgba(0, 0, 0, 0.5);
                        height: 24px;
                        width: 24px;
                        stroke: rgb(255, 255, 255);
                        stroke-width: 2;
                        overflow: visible;
                      "
                    >
                      <path
                        d="m16 28c7-4.733 14-10 14-17 0-1.792-.683-3.583-2.05-4.95-1.367-1.366-3.158-2.05-4.95-2.05-1.791 0-3.583.684-4.949 2.05l-2.051 2.051-2.05-2.051c-1.367-1.366-3.158-2.05-4.95-2.05-1.791 0-3.583.684-4.949 2.05-1.367 1.367-2.051 3.158-2.051 4.95 0 7 7 12.267 14 17z"
                      ></path>
                    </svg>
                  </button>
                </div>
              </div>
            </div>

            <div class="subtitle">
              <div>
                <!-- <svg
                  viewBox="0 0 1000 1000"
                  role="presentation"
                  aria-hidden="true"
                  focusable="false"
                  style="height: 14px; width: 14px; fill: red"
                >
                  <path
                    d="M972 380c9 28 2 50-20 67L725 619l87 280c11 39-18 75-54 75-12 0-23-4-33-12L499 790 273 962a58 58 0 0 1-78-12 50 50 0 0 1-8-51l86-278L46 447c-21-17-28-39-19-67 8-24 29-40 52-40h280l87-279c7-23 28-39 52-39 25 0 47 17 54 41l87 277h280c24 0 45 16 53 40z"
                  ></path>
                </svg>
                4.95 (37) -->
              </div>
            </div>
            <p>
              {{ item.title }}
            </p>
            <p>{{ item.summary }}</p>
            <p>Distance from this listing: {{ item.distance }} miles </p>
          </a>
          <p>
            <b>${{ item.cost }}</b> / person
          </p>
        </div>
      </template>
    </horizontal-list>
  </div>
</template>

<script>
import HorizontalList from "./HorizontalList.vue";
import axios from "axios";
export default {
  props: ["listingId"],
  name: "events",
  components: {
    HorizontalList,
  },
  data() {
    return {
      items: [],
      options: {
        responsive: [
          { end: 576, size: 1 },
          { start: 576, end: 768, size: 2 },
          { start: 768, end: 992, size: 3 },
          { size: 4 },
        ],
      },
    };
  },
  mounted() {
    axios


      .get(`http://54.91.69.145:80/api/events/${this.$route.props.listingId}/25`)

      .then((res) => {
        this.items = res.data;
      })
      .catch((err) => Promise.reject(err));
  },
  methods: {
    saved(id) {
      alert(`You saved listing with id: ${id}!`);
    },
  },
};
</script>

<style scoped>
a,
a:hover,
a:focus,
a:active {
  text-decoration: none;
  color: inherit;
}
p {
  margin-top: 6px;
  margin: 0;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
.subtitle {
  margin-top: 8px;
  margin-bottom: 6px;
  display: flex;
  justify-content: space-between;
  font-size: 14px;
  font-weight: 500;
}
.image-container {
  border-radius: 3px;
  overflow: hidden;
  position: relative;
  width: 100%;
  padding-top: 60%;
}
img {
  object-fit: cover;
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
}
</style>
