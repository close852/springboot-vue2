<template>
    <div>
        parameter :{{param}} 
        <br>query :{{query}}

    </div>
</template>

<script>
export default {
  computed: {
    param: function() {
      return this.$route.params;
    },
    query: function() {
      return this.$route.query;
    }
  },
  created() {
    const id = this.$route.params.id;
    const qName = this.$route.query;
    console.log(id, qName);
    if (!id) {
      this.$route.go(-1);
    } else if (id == 1) {
      // router는 특정 경로로 이동(redirect 인듯)
      this.$router.push("/about");
    }
  }
};
</script>
