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
    <el-form-item label="" prop="loadx1">
      <el-input v-model="dataForm.loadx1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loady1">
      <el-input v-model="dataForm.loady1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loadz1">
      <el-input v-model="dataForm.loadz1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loadx2">
      <el-input v-model="dataForm.loadx2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loady2">
      <el-input v-model="dataForm.loady2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loadz2">
      <el-input v-model="dataForm.loadz2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loadx3">
      <el-input v-model="dataForm.loadx3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loady3">
      <el-input v-model="dataForm.loady3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loadz3">
      <el-input v-model="dataForm.loadz3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loadx4">
      <el-input v-model="dataForm.loadx4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loady4">
      <el-input v-model="dataForm.loady4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="loadz4">
      <el-input v-model="dataForm.loadz4" placeholder=""></el-input>
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
          loadx1: '',
          loady1: '',
          loadz1: '',
          loadx2: '',
          loady2: '',
          loadz2: '',
          loadx3: '',
          loady3: '',
          loadz3: '',
          loadx4: '',
          loady4: '',
          loadz4: '',
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
          loadx1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loady1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loadz1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loadx2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loady2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loadz2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loadx3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loady3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loadz3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loadx4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loady4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          loadz4: [
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
              url: this.$http.adornUrl(`/jydbjdj/lwlocaload/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.aircraftId = data.lwLocaload.aircraftId
                this.dataForm.flightId = data.lwLocaload.flightId
                this.dataForm.fixtureId = data.lwLocaload.fixtureId
                this.dataForm.loadx1 = data.lwLocaload.loadx1
                this.dataForm.loady1 = data.lwLocaload.loady1
                this.dataForm.loadz1 = data.lwLocaload.loadz1
                this.dataForm.loadx2 = data.lwLocaload.loadx2
                this.dataForm.loady2 = data.lwLocaload.loady2
                this.dataForm.loadz2 = data.lwLocaload.loadz2
                this.dataForm.loadx3 = data.lwLocaload.loadx3
                this.dataForm.loady3 = data.lwLocaload.loady3
                this.dataForm.loadz3 = data.lwLocaload.loadz3
                this.dataForm.loadx4 = data.lwLocaload.loadx4
                this.dataForm.loady4 = data.lwLocaload.loady4
                this.dataForm.loadz4 = data.lwLocaload.loadz4
                this.dataForm.time = data.lwLocaload.time
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
              url: this.$http.adornUrl(`/jydbjdj/lwlocaload/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'aircraftId': this.dataForm.aircraftId,
                'flightId': this.dataForm.flightId,
                'fixtureId': this.dataForm.fixtureId,
                'loadx1': this.dataForm.loadx1,
                'loady1': this.dataForm.loady1,
                'loadz1': this.dataForm.loadz1,
                'loadx2': this.dataForm.loadx2,
                'loady2': this.dataForm.loady2,
                'loadz2': this.dataForm.loadz2,
                'loadx3': this.dataForm.loadx3,
                'loady3': this.dataForm.loady3,
                'loadz3': this.dataForm.loadz3,
                'loadx4': this.dataForm.loadx4,
                'loady4': this.dataForm.loady4,
                'loadz4': this.dataForm.loadz4,
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
