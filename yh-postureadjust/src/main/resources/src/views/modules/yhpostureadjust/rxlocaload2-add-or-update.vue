<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="aircraftId">
      <el-input v-model="dataForm.aircraftId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="flightId">
      <el-input v-model="dataForm.flightId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="fixtureId">
      <el-input v-model="dataForm.fixtureId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loadx5">
      <el-input v-model="dataForm.loadx5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loady5">
      <el-input v-model="dataForm.loady5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loadz5">
      <el-input v-model="dataForm.loadz5" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loadx6">
      <el-input v-model="dataForm.loadx6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loady6">
      <el-input v-model="dataForm.loady6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loadz6">
      <el-input v-model="dataForm.loadz6" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loadx7">
      <el-input v-model="dataForm.loadx7" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loady7">
      <el-input v-model="dataForm.loady7" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loadz7">
      <el-input v-model="dataForm.loadz7" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loadx8">
      <el-input v-model="dataForm.loadx8" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loady8">
      <el-input v-model="dataForm.loady8" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loadz8">
      <el-input v-model="dataForm.loadz8" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="time">
      <el-input v-model="dataForm.time" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          aircraftId: '',
          flightId: '',
          fixtureId: '',
          loadx5: '',
          loady5: '',
          loadz5: '',
          loadx6: '',
          loady6: '',
          loadz6: '',
          loadx7: '',
          loady7: '',
          loadz7: '',
          loadx8: '',
          loady8: '',
          loadz8: '',
          time: ''
        },
        dataRule: {
          aircraftId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          flightId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          fixtureId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loadx5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loady5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loadz5: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loadx6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loady6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loadz6: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loadx7: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loady7: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loadz7: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loadx8: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loady8: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loadz8: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          time: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/yhpostureadjust/rxlocaload2/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.aircraftId = data.rxLocaload2.aircraftId
                this.dataForm.flightId = data.rxLocaload2.flightId
                this.dataForm.fixtureId = data.rxLocaload2.fixtureId
                this.dataForm.loadx5 = data.rxLocaload2.loadx5
                this.dataForm.loady5 = data.rxLocaload2.loady5
                this.dataForm.loadz5 = data.rxLocaload2.loadz5
                this.dataForm.loadx6 = data.rxLocaload2.loadx6
                this.dataForm.loady6 = data.rxLocaload2.loady6
                this.dataForm.loadz6 = data.rxLocaload2.loadz6
                this.dataForm.loadx7 = data.rxLocaload2.loadx7
                this.dataForm.loady7 = data.rxLocaload2.loady7
                this.dataForm.loadz7 = data.rxLocaload2.loadz7
                this.dataForm.loadx8 = data.rxLocaload2.loadx8
                this.dataForm.loady8 = data.rxLocaload2.loady8
                this.dataForm.loadz8 = data.rxLocaload2.loadz8
                this.dataForm.time = data.rxLocaload2.time
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/yhpostureadjust/rxlocaload2/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'aircraftId': this.dataForm.aircraftId,
                'flightId': this.dataForm.flightId,
                'fixtureId': this.dataForm.fixtureId,
                'loadx5': this.dataForm.loadx5,
                'loady5': this.dataForm.loady5,
                'loadz5': this.dataForm.loadz5,
                'loadx6': this.dataForm.loadx6,
                'loady6': this.dataForm.loady6,
                'loadz6': this.dataForm.loadz6,
                'loadx7': this.dataForm.loadx7,
                'loady7': this.dataForm.loady7,
                'loadz7': this.dataForm.loadz7,
                'loadx8': this.dataForm.loadx8,
                'loady8': this.dataForm.loady8,
                'loadz8': this.dataForm.loadz8,
                'time': this.dataForm.time
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
