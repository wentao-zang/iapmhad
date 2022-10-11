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
    <el-form-item label="" prop="locasx1">
      <el-input v-model="dataForm.locasx1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasy1">
      <el-input v-model="dataForm.locasy1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasz1">
      <el-input v-model="dataForm.locasz1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasx2">
      <el-input v-model="dataForm.locasx2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasy2">
      <el-input v-model="dataForm.locasy2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasz2">
      <el-input v-model="dataForm.locasz2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasx3">
      <el-input v-model="dataForm.locasx3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasy3">
      <el-input v-model="dataForm.locasy3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasz3">
      <el-input v-model="dataForm.locasz3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasx4">
      <el-input v-model="dataForm.locasx4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasy4">
      <el-input v-model="dataForm.locasy4" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="locasz4">
      <el-input v-model="dataForm.locasz4" placeholder=""></el-input>
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
          locasx1: '',
          locasy1: '',
          locasz1: '',
          locasx2: '',
          locasy2: '',
          locasz2: '',
          locasx3: '',
          locasy3: '',
          locasz3: '',
          locasx4: '',
          locasy4: '',
          locasz4: '',
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
          locasx1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasy1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasz1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasx2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasy2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasz2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasx3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasy3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasz3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasx4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasy4: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          locasz4: [
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
              url: this.$http.adornUrl(`/yhpostureadjust/lslocastan1/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.aircraftId = data.lsLocastan1.aircraftId
                this.dataForm.flightId = data.lsLocastan1.flightId
                this.dataForm.fixtureId = data.lsLocastan1.fixtureId
                this.dataForm.locasx1 = data.lsLocastan1.locasx1
                this.dataForm.locasy1 = data.lsLocastan1.locasy1
                this.dataForm.locasz1 = data.lsLocastan1.locasz1
                this.dataForm.locasx2 = data.lsLocastan1.locasx2
                this.dataForm.locasy2 = data.lsLocastan1.locasy2
                this.dataForm.locasz2 = data.lsLocastan1.locasz2
                this.dataForm.locasx3 = data.lsLocastan1.locasx3
                this.dataForm.locasy3 = data.lsLocastan1.locasy3
                this.dataForm.locasz3 = data.lsLocastan1.locasz3
                this.dataForm.locasx4 = data.lsLocastan1.locasx4
                this.dataForm.locasy4 = data.lsLocastan1.locasy4
                this.dataForm.locasz4 = data.lsLocastan1.locasz4
                this.dataForm.time = data.lsLocastan1.time
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
              url: this.$http.adornUrl(`/yhpostureadjust/lslocastan1/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'aircraftId': this.dataForm.aircraftId,
                'flightId': this.dataForm.flightId,
                'fixtureId': this.dataForm.fixtureId,
                'locasx1': this.dataForm.locasx1,
                'locasy1': this.dataForm.locasy1,
                'locasz1': this.dataForm.locasz1,
                'locasx2': this.dataForm.locasx2,
                'locasy2': this.dataForm.locasy2,
                'locasz2': this.dataForm.locasz2,
                'locasx3': this.dataForm.locasx3,
                'locasy3': this.dataForm.locasy3,
                'locasz3': this.dataForm.locasz3,
                'locasx4': this.dataForm.locasx4,
                'locasy4': this.dataForm.locasy4,
                'locasz4': this.dataForm.locasz4,
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
