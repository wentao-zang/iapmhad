<template>
  <el-dialog
    :title="!dataForm.fixtureid ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="pointname">
      <el-input v-model="dataForm.pointname" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="theoryX">
      <el-input v-model="dataForm.theoryX" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="theoryY">
      <el-input v-model="dataForm.theoryY" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="theoryZ">
      <el-input v-model="dataForm.theoryZ" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="theoryA">
      <el-input v-model="dataForm.theoryA" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="theoryB">
      <el-input v-model="dataForm.theoryB" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="theoryC">
      <el-input v-model="dataForm.theoryC" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="actualX">
      <el-input v-model="dataForm.actualX" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="actualY">
      <el-input v-model="dataForm.actualY" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="actualZ">
      <el-input v-model="dataForm.actualZ" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="actualA">
      <el-input v-model="dataForm.actualA" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="actualB">
      <el-input v-model="dataForm.actualB" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="actualC">
      <el-input v-model="dataForm.actualC" placeholder=""></el-input>
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
          fixtureid: 0,
          pointname: '',
          theoryX: '',
          theoryY: '',
          theoryZ: '',
          theoryA: '',
          theoryB: '',
          theoryC: '',
          actualX: '',
          actualY: '',
          actualZ: '',
          actualA: '',
          actualB: '',
          actualC: '',
          time: ''
        },
        dataRule: {
          pointname: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          theoryX: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          theoryY: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          theoryZ: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          theoryA: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          theoryB: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          theoryC: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          actualX: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          actualY: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          actualZ: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          actualA: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          actualB: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          actualC: [
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
        this.dataForm.fixtureid = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.fixtureid) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/holenormalmodify/info/${this.dataForm.fixtureid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.pointname = data.holeNormalmodify.pointname
                this.dataForm.theoryX = data.holeNormalmodify.theoryX
                this.dataForm.theoryY = data.holeNormalmodify.theoryY
                this.dataForm.theoryZ = data.holeNormalmodify.theoryZ
                this.dataForm.theoryA = data.holeNormalmodify.theoryA
                this.dataForm.theoryB = data.holeNormalmodify.theoryB
                this.dataForm.theoryC = data.holeNormalmodify.theoryC
                this.dataForm.actualX = data.holeNormalmodify.actualX
                this.dataForm.actualY = data.holeNormalmodify.actualY
                this.dataForm.actualZ = data.holeNormalmodify.actualZ
                this.dataForm.actualA = data.holeNormalmodify.actualA
                this.dataForm.actualB = data.holeNormalmodify.actualB
                this.dataForm.actualC = data.holeNormalmodify.actualC
                this.dataForm.time = data.holeNormalmodify.time
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
              url: this.$http.adornUrl(`/ame_hdym/holenormalmodify/${!this.dataForm.fixtureid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'fixtureid': this.dataForm.fixtureid || undefined,
                'pointname': this.dataForm.pointname,
                'theoryX': this.dataForm.theoryX,
                'theoryY': this.dataForm.theoryY,
                'theoryZ': this.dataForm.theoryZ,
                'theoryA': this.dataForm.theoryA,
                'theoryB': this.dataForm.theoryB,
                'theoryC': this.dataForm.theoryC,
                'actualX': this.dataForm.actualX,
                'actualY': this.dataForm.actualY,
                'actualZ': this.dataForm.actualZ,
                'actualA': this.dataForm.actualA,
                'actualB': this.dataForm.actualB,
                'actualC': this.dataForm.actualC,
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
