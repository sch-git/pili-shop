<template>
    <iframe :src="formData" width="1000px" height="300px"></iframe>
</template>

<script>
export default {
  name: 'Code',
  data () {
    return {
      url: ''
    }
  },
  created () {
  },
  mounted () {
  },
  methods: {

  },
  computed: {
    formData () {
      return this.$store.state.payForm
    }
  }
}
</script>

<style scoped>

</style>
